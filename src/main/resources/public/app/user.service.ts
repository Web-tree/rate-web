import {Injectable} from "@angular/core";
import {Service} from "./service";
import {Response, Http} from "@angular/http";
import {Observable} from "rxjs";
import * as Collections from "typescript-collections";
@Injectable()
export class UserService extends Service {
    private user: User;
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

    public getRateList(): Observable<Collections.List<User>> {
        return this.http
            .get(this.url('rate-list'))
            .map((r: Response) => r.json().data as User);
    }

    public login(): void {
        //TODO: remove stub
        this.findUser(1).subscribe(user => this.user = user);
    }

    public logout(): void {
        this.user = null;
    }

    public isAuth(): boolean {
        return !!this.user;
    }

    public getCurrentUser(): User {
        return this.user;
    }
}