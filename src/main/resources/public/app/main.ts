import {bootstrap}    from 'angular2/platform/browser'
import {AppComponent} from './app.component'
import {appRouterProviders} from './app.routes';

bootstrap(AppComponent, [
    appRouterProviders
])
    .catch(err => console.error(err));