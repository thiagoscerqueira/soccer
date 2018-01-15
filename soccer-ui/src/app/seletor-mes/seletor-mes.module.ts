import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SeletorMesComponent } from './seletor-mes.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule} from '@angular/forms';
import {ButtonModule, CalendarModule, DataTableModule, InputMaskModule, InputTextModule} from 'primeng/primeng';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [SeletorMesComponent],
  exports: [SeletorMesComponent]
})
export class SeletorMesModule { }
