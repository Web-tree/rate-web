import {PropertyNotFound} from "./exception";
import {RestService} from "./rest.service";
export class UrlHelper {
    public static security(path?: string) {
        let url = Properties.get("securityUrl");
        url = UrlHelper.addPath(url, path);
        console.log("Security url: " + url);
        return url;
    }
    public static rest(path?: string, service?: RestService): string {
        let url = Properties.get("restUrl");
        if (service != null) {
            url = UrlHelper.addPath(url, service.getServiceUrl());
        }
        url = UrlHelper.addPath(url, path);
        console.log("Rest url: " + url);
        return url;
    }
    private static addPath(url: string, path: string): string {
        if (path != null) {
            url += '/' + path;
        }
        return url;
    }
}

export class Properties {
    private static properties = {
        restUrl: "/rest",
        securityUrl: "/security"
    };

    public static get(param: string) {
        if (!this.properties[param]) {
            throw new PropertyNotFound(param);
        }
        return this.properties[param];
    }
}