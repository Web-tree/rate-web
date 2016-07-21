import { ROUTER_DIRECTIVES } from '@angular/router';
import {provideRouter, RouterConfig} from '@angular/router';
import {UserComponent} from "./user.component";
import {HomeComponent} from "./home.component";

const routes: RouterConfig = [
    {path: 'user', component: UserComponent},
    {path: '', component: HomeComponent}
];

export const appRouterProviders = [
    provideRouter(routes)
];