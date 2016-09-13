import {Injectable} from "@angular/core";
import {ApiResponse} from "./model";
import {ServerErrorException, NotFoundException, ImplementationException} from "./exception";
@Injectable()
export class RestHandlersHolder {
    public handlers: RestHandler[] = [];
    constructor() {
        this.handlers.push(
            //OK
            new RestHandlerImpl(0, (r: ApiResponse<any>) => r.data),
            //NOT_FOUND
            new RestHandlerImpl(1, (r: ApiResponse<any>) => {throw new NotFoundException(r.status.message);}),
            //ERROR
            new RestHandlerImpl(2, (r: ApiResponse<any>) => {throw new ServerErrorException(r.status.message);})
        );
    }

    public handle(r: ApiResponse<any>): any {
        console.log("Handle response: ", r);
        let handler = this.handlers.filter((handler) => handler.acceptable(r));
        if (handler.length == 1) {
            return handler.pop().handle(r);
        } else {
            let message = "Can't find handler for response";
            console.error(message, r);
            throw new ImplementationException(message);
        }
    }
}

interface RestHandler {
    handle(response: ApiResponse<any>);
    acceptable(response: ApiResponse<any>);
}
class RestHandlerImpl implements RestHandler {
    constructor(public status: number, public handler: (r: ApiResponse<any>) => any) {}

    acceptable(response): boolean {
        return this.status === response.status.type.code;
    }
    handle(response: ApiResponse<any>): any {
        return this.handler(response);
    }

}