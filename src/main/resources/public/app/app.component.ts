import {Component} from "@angular/core";
import {ROUTER_DIRECTIVES} from "@angular/router";
import {UserService} from "./user.service";
import {SecurityService} from "./security.service";

@Component({
    selector: 'rate-app',
    templateUrl: 'templates/app.html',
    directives: [ROUTER_DIRECTIVES],
    providers: [UserService, SecurityService]
})
export class AppComponent {
    constructor(private userService: UserService, private securityService: SecurityService) {
        //TODO: Stub. Remove.
        this.signIn();
    }

    public signIn(): void {
        // TODO: remove stub
        this.securityService.signIn("qwe", "test");
    }

    public signOut(): void {
        this.securityService.signOut();
    }

    public checkAuth(): boolean {
        return this.securityService.checkAuth();
    }

    public getCurrentUser(): User {
        return this.securityService.getCurrentUser();
    }
}