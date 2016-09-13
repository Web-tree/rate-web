import {Injectable} from "@angular/core";
import {Response, Http} from "@angular/http";
import {Observable} from "rxjs";
import {User} from "./model";
import {RestServiceImpl} from "./rest.service";
import {TokenService} from "./token.service";
import {UrlHelper} from "./util";
import {RestHandlersHolder} from "./rest.handlers";
@Injectable()
export class UserService extends RestServiceImpl<User> {
    private user: User;
    constructor(http: Http, tokenService: TokenService, protected handler: RestHandlersHolder) {
        super(http, tokenService, handler);
    }

    public getServiceUrl(): string {
        return "user";
    }
    public signOut(): void {
        this.user = null;
    }



    public getCurrentUser(): User {
        return this.user;
    }
    public findUser(userId: number): Observable<User> {
        return this.http
            .get(UrlHelper.rest('info?userId=' + userId))
            .map((r: Response) => r.json().data as User);
    }

    public signIn(username: string, password: string): void {
        this.http
            .get(UrlHelper.security('/getToken?username=' + username + "&password=" + password))
            .map((r: Response) => this.handler.handle(r.json()) as string)
            .subscribe(
                token => {
                    this.tokenService.saveUserToken(token);
                    this.loadCurrentUser(this.tokenService.getUserToken())
                        .subscribe(user => {this.user = user; console.log("User signed in.", user)})
                }
            );
    }

    public loadCurrentUser(token): Observable<User> {
        return this.http
            .get(UrlHelper.rest('user/currentUser?token=' + token))
            .map((r: Response) => this.handler.handle(r.json()) as User);
    }

    public checkAuth(): boolean {
        if (!!this.user) {
            return true;
        } else {
            if (!this.tokenService.getUserToken()) {
                return false;
            } else {
                this.singInWithToken(this.tokenService.getUserToken());
                return false;
            }
        }
    }

    public singInWithToken(token: string): void {
        // this.loadCurrentUser(token)
        //     .subscribe(u => {
        //         // if (u == null) {
        //         //     this.tokenService.clearUserToken();
        //         // }
        //         this.user = u;
        //     });
    }

    public getRateList(): Observable<User[]> {
        return this.http
            .get(UrlHelper.rest('user/rate-list'))
            .map((r: Response) => r.json().data as User[]);
    }
}