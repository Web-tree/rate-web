import { Component } from '@angular/core';
import { ROUTER_DIRECTIVES } from '@angular/router';

@Component({
    selector: 'my-app',
    template: `<h1>My First123 Angular 2 App</h1>
            123
            <a routerLink="/">home</a>
            <a routerLink="/user">user</a>
            <router-outlet></router-outlet>`,
    directives: [ROUTER_DIRECTIVES]
})
export class AppComponent { }