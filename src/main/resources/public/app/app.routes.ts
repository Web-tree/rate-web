import {RouterConfig} from 'angular2/router';
import {UserComponent} from './user.component';

@RouterConfig([
    {path: 'user', component: UserComponent}
])

// export const appRouterProviders = [
//     provideRouter(routes)
// ];