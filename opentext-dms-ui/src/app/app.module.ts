import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { FileSelectorComponent } from './components/file-selector/file-selector.component';
import { HeaderComponent } from './components/header/header.component';
import { MetaDataComponent } from './components/meta-data/meta-data.component';
import { MetaDataFormComponent } from './components/meta-data-form/meta-data-form.component';
import { PdfViewerComponent } from './components/pdf-viewer/pdf-viewer.component';
import { HttpClientModule } from '@angular/common/http';
import { PdfViewerModule } from 'ng2-pdf-viewer';

@NgModule({
  imports:      [ BrowserModule, FormsModule, ReactiveFormsModule, HttpClientModule ],
  declarations: [ AppComponent,  FileSelectorComponent, HeaderComponent, MetaDataComponent, MetaDataFormComponent, PdfViewerComponent],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
