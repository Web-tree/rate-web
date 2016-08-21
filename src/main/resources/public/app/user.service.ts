import {Injectable} from "@angular/core";
import {Service} from "./service";
import {Response, Http} from "@angular/http";
import {Observable} from "rxjs";
import * as Collections from "typescript-collections";
@Injectable()
export class UserService extends Service {
    constructor(private http: Http) {
        super();
    }

    protected getServiceUrl(): string {
        return "user";
    }

    public findUser(userId: number): Observable<User> {
        return this.http
            .get(this.url('info?userId=' + userId))
            .map((r: Response) => r.json().data as User);
    }

    public loadCurrentUser(token): Observable<User> {
        //TODO: implement
        return this.http
            .get(this.url('currentUser?token=' + token))
            .map((r: Response) => r.json().data as User);
    }

    public getRateList(): Observable<Collections.List<User>> {
        return this.http
            .get(this.url('rate-list'))
            .map((r: Response) => r.json().data as User);
    }
}