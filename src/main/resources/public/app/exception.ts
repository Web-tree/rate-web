import {BaseException} from "@angular/core";

export abstract class RateException extends BaseException {
}
export class ImplementationException extends RateException {
}
export class RestException extends RateException {
}
export class PropertyNotFound extends RateException {

    constructor(private param: string) {
        super("Property " + param + " not found.");
    }
}
export class ServerErrorException extends RateException {}
export class NotFoundException extends RateException {}