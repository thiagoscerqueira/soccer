import { RouterModule, Routes } from '@angular/router';
import {ListagemPagamentosComponent} from './listagem-pagamentos/listagem-pagamentos.component';

const appRoutes: Routes = [
    { path: '', component: ListagemPagamentosComponent }
];

export const routing = RouterModule.forRoot(appRoutes);
