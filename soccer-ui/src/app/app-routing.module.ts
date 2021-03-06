import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PesquisaJogadorComponent} from './pesquisa-jogador/pesquisa-jogador.component';
import {CadastroJogadorComponent} from './cadastro-jogador/cadastro-jogador.component';
import {PizzaChartComponent} from './pizza-chart/pizza-chart.component';
import {PesquisaPagamentoJogadorComponent} from './pesquisa-pagamento-jogador/pesquisa-pagamento-jogador.component';

const appRoutes: Routes = [
  {path: 'jogadores', component: PesquisaJogadorComponent},
  {path: 'jogadores/novo', component: CadastroJogadorComponent},
  {path: 'jogadores/:id', component: CadastroJogadorComponent},
  {path: 'pizza', component: PizzaChartComponent},
  {path: 'pagamentoJogadores', component: PesquisaPagamentoJogadorComponent},
  {path: '', redirectTo: '/jogadores', pathMatch: 'full'}
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
