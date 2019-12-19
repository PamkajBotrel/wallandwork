# AngularUdev

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 8.3.20.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).

---

## Backend

### Services

To use this application, you have to to run the backend server of [Guillaume Gallois](https://github.com/keuss).
You can find his repository [here](https://github.com/keuss/springboot-udev).

If you want, to run the correct version of the backend, run the version found in the `no-auth` branch ([here](https://github.com/keuss/springboot-udev/tree/no-auth))

If you change the port of the backend server, don't forget to change it also in the `proxy.conf.json` file.

### In Memories

To call `in memory` services, just change  the provider configuration of `app.module.ts`:
```
{provide: BookRepository, useFactory: (http: HttpClient) => new BookService(http), deps: [HttpClient]}
```
with
```
{provide: BookRepository, useClass: BookInMemory}
```
