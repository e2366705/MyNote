import { TestBed } from '@angular/core/testing';

import { XxxxxService } from './xxxxx.service';

describe('XxxxxService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: XxxxxService = TestBed.get(XxxxxService);
    expect(service).toBeTruthy();
  });
});
