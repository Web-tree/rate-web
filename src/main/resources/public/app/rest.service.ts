import {Service} from "./service";
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs";
import {TokenService} from "./token.service";
import {UrlHelper} from "./util";
import {RestHandlersHolder} from "./rest.handlers";

export abstract class RestServiceImpl<T> implements RestService {
    protected baseUrl: string = "/rest/";
    constructor(protected http: Http, protected tokenService: TokenService, protected handler: RestHandlersHolder) {}

    abstract getServiceUrl(): string;

    public findOne(id: number): Observable<T> {
        let url = UrlHelper.rest('get/' + id, this);
        let token = this.tokenService.getUserToken();
        if (token) {
            url += '?token=' + token;
        }
        return this.http
            .get(url)
            .map((r: Response) => this.handler.handle(r.json()) as T);
    }
}
export interface RestService extends Service {
    getServiceUrl(): string;
}
