import {Component} from "@angular/core";
import {ROUTER_DIRECTIVES} from "@angular/router";
import {UserService} from "./user.service";
import {TokenService} from "./token.service";
import {User} from "./model";
import {RestHandlersHolder} from "./rest.handlers";
import {UserRateListComponent} from "./user-rate-list.component";
import {HomeComponent} from "./home.component";

@Component({
    selector: 'rate-app',
    templateUrl: 'templates/app.html',
    directives: [ROUTER_DIRECTIVES],
    precompile: [UserRateListComponent, HomeComponent],
    providers: [UserService, TokenService, RestHandlersHolder]
})
export class AppComponent {
    constructor(private userService: UserService, private securityService: TokenService) {
        //TODO: Stub. Remove.
        this.signIn();
    }

    public signIn(): void {
        // TODO: remove stub
        this.userService.signIn("qwe", "test");
    }

    public signOut(): void {
        this.userService.signOut();
    }

    public checkAuth(): boolean {
        return this.userService.checkAuth();
    }

    public getCurrentUser(): User {
        return this.userService.getCurrentUser();
    }
}