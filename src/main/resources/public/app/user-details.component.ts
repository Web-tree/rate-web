import {Component} from '@angular/core';
import {UserService} from "./user.service";
import {httpFactory} from "@angular/http";
import {ActivatedRoute} from "@angular/router";
@Component({
    selector: 'user-details-comp',
    templateUrl: 'templates/user-details.html',
    providers: [UserService]
})
export class UserListComponent {
    private user: User = null;
    private sub: any;

    constructor(private userService: UserService, private route: ActivatedRoute) {
    }
    ngOnInit() {
        this.sub = this.route.params.subscribe(params => {
            let id = +params['id']; // (+) converts string 'id' to a number
            this.userService.findUser(id).subscribe(user => this.user = user);
        });
    }

    ngOnDestroy() {
        this.sub.unsubscribe();
    }
}