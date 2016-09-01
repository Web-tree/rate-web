import {Injectable} from "@angular/core";
import {Service} from "./service";
import {Response, Http} from "@angular/http";
import {UserService} from "./user.service";
import {User} from "./model";

@Injectable()
export class SecurityService extends Service {
    private user: User;
    constructor(private http: Http, private userService: UserService) {
        super();
        this.setBaseUrl("/");
    }

    protected getServiceUrl(): string {
        return "security";
    }

    public signIn(username: string, password: string): void {
        this.http
            .get(this.url('getToken?username=' + username + "&password=" + password))
            .map((r: Response) => r.json().data as string)
            .subscribe(
                token => {
                    this.saveUserToken(token);
                    this.userService.loadCurrentUser(this.getUserToken())
                        .subscribe(user => {this.user = user; console.log(user)})
                }
            );
    }

    public signOut(): void {
        this.user = null;
    }

    public checkAuth(): boolean {
        if (!!this.user) {
            return true;
        } else {
            if (!this.getUserToken()) {
                return false;
            } else {
                this.singInWithToken(this.getUserToken());
                return false;
            }
        }
    }

    public getCurrentUser(): User {
        return this.user;
    }

    private singInWithToken(token: string): void {
        //TODO: implement
    }

    private saveUserToken(token: string): void {
        //TODO: implement
    }

    private getUserToken(): string {
        //TODO: remove stub
        return "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJxd2UiLCJjcmVhdGVkIjoxNDcxNzg4NzY1MDcxLCJleHAiOjE1OTUxMTAwODZ9.Cgeeh69aH_y6K0lzLnabmubSWHVDdOhZXvGwn2Gy0yko6LdeO-TvVIC5DX6TjZtacM6fWpJ4f3NDxrDh-pXjVQ";
    }
}