import { ROUTER_DIRECTIVES } from '@angular/router';
import {provideRouter, RouterConfig} from '@angular/router';
import {UserListComponent} from "./user-details.component";
import {HomeComponent} from "./home.component";
import {UserRateListComponent} from "./user-rate-list.component";

const routes: RouterConfig = [
    {path: 'user/details/:id', component: UserListComponent},
    {path: 'user/rate/list', component: UserRateListComponent},
    {path: '', component: HomeComponent}
];

export const appRouterProviders = [
    provideRouter(routes)
];