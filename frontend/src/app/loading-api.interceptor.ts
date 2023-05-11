import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable, finalize, tap } from 'rxjs';
import { SpinnerService } from './services/spinner.service';

@Injectable()
export class LoadingApiInterceptor implements HttpInterceptor {

  constructor(private spinnerService: SpinnerService) { }

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    return next.handle(request)
      .pipe(
        tap(() => this.spinnerService.showSpinner$.next(true)),
        finalize(() => this.spinnerService.showSpinner$.next(false))
      );
  }
}
