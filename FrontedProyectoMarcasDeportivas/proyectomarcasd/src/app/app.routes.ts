import { Routes } from '@angular/router';
import { AdidasComponent } from './adidas/adidas.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { NikeComponent } from './nike/nike.component';
import { PumaComponent } from './puma/puma.component';
import { FormAdidasComponent } from './adidas/adidasForm/form-adidas.component';
import { FormNikeComponent } from './nike/nikeForm/form-nike.component';
import { FormPumaComponent } from './puma/pumaForm/form-puma.component';
import { MarcasDeportivasComponent } from './marcas_deportivas/marcas-deportivas.component';

export const routes: Routes = [
    {path: '', redirectTo:'/marcas_deportivas', pathMatch:'full'},
    {path: 'adidas', component: AdidasComponent},
    {path: 'header', component: HeaderComponent},
    {path: 'footer', component: FooterComponent},
    {path: 'nike', component: NikeComponent},
    {path: 'puma', component: PumaComponent},
    {path: 'marcas_deportivas', component: MarcasDeportivasComponent},
    {path: 'adidas/form', component: FormAdidasComponent},
    {path: 'nike/form', component: FormNikeComponent},
    {path: 'puma/form', component: FormPumaComponent},
    {path: 'adidas/form/:id', component: FormAdidasComponent},
    {path: 'nike/form/:id', component: FormNikeComponent},
    {path: 'puma/form/:id', component: FormPumaComponent}
];
