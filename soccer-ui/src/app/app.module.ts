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
import {FormsModule} from '@angular/forms';
import {ButtonModule} from 'primeng/button';
import {JogadorService} from './service/jogador.service';
import {TableModule} from 'primeng/table';
import {MenubarModule} from 'primeng/menubar';
import {PanelModule} from 'primeng/panel';

const appRoutes: Routes = [
  {path: 'jogadores', component: PesquisaJogadorComponent},
  {path: 'jogadores/novo', component: CadastroJogadorComponent},
  {path: 'jogadores/editar/:id', component: CadastroJogadorComponent},
  {path: '',
    redirectTo: '/jogadores',
    pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    PesquisaJogadorComponent,
    NavbarComponent,
    CadastroJogadorComponent
  ],
  imports: [
    RouterModule.forRoot(
      appRoutes,
      {enableTracing: true} // <-- debugging purposes only
    ),
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule,

    DataTableModule,
    TableModule,
    ButtonModule,
    InputTextModule,
    InputMaskModule,
    CalendarModule,
    MenubarModule,
    PanelModule,
    ToolbarModule
  ],
  providers: [JogadorService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
