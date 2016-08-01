import { Component } from '@angular/core';
import { ROUTER_DIRECTIVES } from '@angular/router';
import {UserService} from "./user.service";

@Component({
    selector: 'rate-app',
    templateUrl: 'templates/app.html',
    directives: [ROUTER_DIRECTIVES],
    providers: [UserService]
})
export class AppComponent {
    constructor(private userService: UserService) {
    }

    public login(): void {
        this.userService.login();
    }

    public logout(): void {
        this.userService.logout();
    }

    public isAuth(): boolean {
        return this.userService.isAuth();
    }

    public getCurrentUser(): User {
        return this.userService.getCurrentUser();
    }
}