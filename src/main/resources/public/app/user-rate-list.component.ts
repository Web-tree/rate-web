import {Component} from "@angular/core";
import {UserService} from "./user.service";
import * as Collections from "typescript-collections";
import {ROUTER_DIRECTIVES} from "@angular/router";
import {User} from "./model";

@Component({
    selector: 'user-rate-list-comp',
    templateUrl: 'templates/user-rate-list.html',
    directives: [ROUTER_DIRECTIVES],
    providers: [UserService]
})
export class UserRateListComponent {
    private users: Collections.List<User> = null;
    constructor(private userService: UserService) {
        this.userService.getRateList().subscribe(users => this.users = users);
    }
}