import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {PesquisaJogadorComponent} from './pesquisa-jogador/pesquisa-jogador.component';
import {NavbarComponent} from './navbar/navbar.component';
import {CalendarModule, DataTableModule, InputMaskModule, InputTextModule, ToolbarModule} from 'primeng/primeng';
import { CadastroJogadorComponent } from './cadastro-jogador/cadastro-jogador.component';
import {RouterModule, Routes} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {ButtonModule} from 'primeng/button';
import {JogadorService} from './service/jogador.service';
import {TableModule} from 'primeng/table';
import {MenubarModule} from 'primeng/menubar';
import {PanelModule} from 'primeng/panel';
import {AppRoutingModule} from './app-routing.module';
import {GrowlModule} from 'primeng/growl';
import {MessageService} from 'primeng/components/common/messageservice';
import { PizzaChartComponent } from './pizza-chart/pizza-chart.component';
import {ChartModule} from 'primeng/chart';


@NgModule({
  declarations: [
    AppComponent,
    PesquisaJogadorComponent,
    NavbarComponent,
    CadastroJogadorComponent,
    PizzaChartComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    DataTableModule,
    TableModule,
    ButtonModule,
    InputTextModule,
    InputMaskModule,
    CalendarModule,
    MenubarModule,
    GrowlModule,
    ChartModule
  ],
  providers: [JogadorService, MessageService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
