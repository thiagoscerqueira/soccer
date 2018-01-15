import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import {SeletorMesModule} from './seletor-mes/seletor-mes.module';
import {
  ButtonModule, CalendarModule, DataTableModule, DialogModule, InputMaskModule,
  InputTextModule
} from 'primeng/primeng';
import {FormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HttpClientModule} from '@angular/common/http';
import { routing } from './app.routes';
import { ListagemPagamentosComponent } from './listagem-pagamentos/listagem-pagamentos.component';
import {NavbarComponent} from './navbar/navbar.component';
import {PagamentoService} from './listagem-pagamentos/PagamentoService';
import {JogadorService} from './listagem-pagamentos/JogadorService';

@NgModule({
  declarations: [
    AppComponent,
    ListagemPagamentosComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    SeletorMesModule,
    HttpClientModule,
    routing,
    BrowserAnimationsModule,
    FormsModule,
    DataTableModule,
    ButtonModule,
    InputTextModule,
    InputMaskModule,
    CalendarModule,
    DialogModule
  ],
  providers: [ PagamentoService, JogadorService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
