import { TestBed } from '@angular/core/testing';

import { LoadingApiInterceptor } from './loading-api.interceptor';

describe('LoadingApiInterceptor', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      LoadingApiInterceptor
      ]
  }));

  it('should be created', () => {
    const interceptor: LoadingApiInterceptor = TestBed.inject(LoadingApiInterceptor);
    expect(interceptor).toBeTruthy();
  });
});
