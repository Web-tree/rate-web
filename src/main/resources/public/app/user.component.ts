import {Component} from '@angular/core';
import {UserService} from "./user.service";
import {httpFactory} from "@angular/http";
@Component({
    selector: 'user-comp',
    templateUrl: 'templates/user.details.html',
    providers: [UserService]
})
export class UserComponent {
    private user: User = null;
    constructor(private userService: UserService) {
        this.userService.findUser(2).subscribe(user => this.user = user);
    }
}