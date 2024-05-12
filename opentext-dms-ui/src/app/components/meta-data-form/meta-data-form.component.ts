import { Component, OnInit } from '@angular/core';
import { CommonServiceService } from '../../services/common-service.service';
import { OnChanges } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { FormArray } from '@angular/forms';

@Component({
  selector: 'app-meta-data-form',
  templateUrl: './meta-data-form.component.html',
  styleUrls: ['./meta-data-form.component.css']
})
export class MetaDataFormComponent implements OnInit, OnChanges {

  metaData: any;

  form: FormGroup;

  constructor(private service: CommonServiceService, private fb: FormBuilder) { 
    this.form = this.fb.group({
      metaDataFieldValues: this.fb.array([])
    })
  }

  ngOnInit() {
    this.getData();
  }

  ngOnChanges() {
    this.getData();
  }

  getData() {
    this.service.getMetaData().subscribe((d: any) => {
      if(d) {
        this.metaData = d.metaData;
      }
    });
  }

  setForm() {
    if(this.metaData) { 
      this.metaData.forEach((e: any) => {
        this.metaDataFieldValues.push(
          new FormGroup({
            metaDataFieldValue: new FormControl()
          })
        )
      });
    }
  }

  get metaDataFieldValues() {
    return this.form.controls['metaDataFieldValues'] as FormArray;
  }

  getTitle(index: number) {
    this.metaData.forEach((d: any, i: number) => {
      if(i == index) {
        return d.title;
      }
    })
  }

  getType(index: number) {
    this.metaData.forEach((d: any, i: number) => {
      if(i == index) {
        return d.type;
      }
    })
  }

  saveFileNdMetaData() {
      this.service.saveFileNdMetaData(this.metaDataFieldValues.value);
      this.service.setMetaData(null);
      this.service.setFile(null);
  }

}