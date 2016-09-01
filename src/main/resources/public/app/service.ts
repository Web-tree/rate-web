export abstract class Service {
    private baseUrl: string = "/rest/";

    protected abstract getServiceUrl(): string;

    public url(path: string): string {
        var url = this.baseUrl + this.getServiceUrl();
        if (path != null) {
            url += '/' + path;
        }
        console.log(url);
        return url;
    }

    protected setBaseUrl(url: string) {
        this.baseUrl = url
    }
}