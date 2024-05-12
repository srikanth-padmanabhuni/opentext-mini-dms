import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable(
  {providedIn: 'root'}
)
export class CommonServiceService {

  BASE_URL: string = "http://localhost:8080/api/"

  metaData: any = new BehaviorSubject<any>(null);

  file: any = new BehaviorSubject<any>(null);

  constructor(private http: HttpClient) { }

  setMetaData(md: any) {
    this.metaData.next(md);
  }

  getMetaData() {
    return this.metaData.asObservable();
  }

  setFile(file: any) {
    this.file.next(file);
  }

  getFile() {
    return this.file.asObservable();
  }

  saveMetaData(metaData: any): Observable<any> {
    this.setMetaData(metaData);
    return this.http.post<any>(this.BASE_URL + "metadata/save", metaData);
  }

  saveFileNdMetaData(metaDataFieldValues: any) {
    const formData = new FormData();
    this.getFile().subscribe((f: any) => {
      formData.append('file', f);
    });
    formData.append('metaData', metaDataFieldValues);
    return this.http.post<any>(this.BASE_URL + "file/save", formData);
  }

}