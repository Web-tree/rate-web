import {Injectable} from "@angular/core";
import {Service} from "./service";

@Injectable()
export class TokenService implements Service {
    private token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJxd2UiLCJjcmVhdGVkIjoxNDcxNzg4NzY1MDcxLCJleHAiOjE1OTUxMTAwODZ9.Cgeeh69aH_y6K0lzLnabmubSWHVDdOhZXvGwn2Gy0yko6LdeO-TvVIC5DX6TjZtacM6fWpJ4f3NDxrDh-pXjVQ";
    public saveUserToken(token: string): void {
        //TODO: implement
        this.token = token;
    }

    public clearUserToken(): void {
        //TODO: implement
        this.token = null;
    }

    public getUserToken(): string {
        //TODO: remove stub
        return this.token;
    }
}