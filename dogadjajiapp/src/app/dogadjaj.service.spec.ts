import { TestBed } from '@angular/core/testing';

import { DogadjajService } from './dogadjaj.service';

describe('DogadjajService', () => {
  let service: DogadjajService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DogadjajService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
