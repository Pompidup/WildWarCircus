import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DashboardComponent } from './dashboard/dashboard.component';
import { PubComponent } from './pub/pub.component';
import { ShowComponent } from './show/show.component';
import { StandComponent } from './stand/stand.component';
import { FirstCircusComponent } from './first-circus/first-circus.component';
import { UpgradeCircusComponent } from './upgrade-circus/upgrade-circus.component';
import { CrasseComponent } from './crasse/crasse.component';
import { ResumeOfSaturdayComponent } from './resume-of-saturday/resume-of-saturday.component';
import { OpponentComponent } from './opponent/opponent.component';
import { ErrorInterceptor } from './_helpers/error.interceptor';
import { JwtInterceptor } from './_helpers/jwt.interceptor'
import { LoginComponent } from './login/login';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    PubComponent,
    ShowComponent,
    StandComponent,
    FirstCircusComponent,
    UpgradeCircusComponent,
    CrasseComponent,
    ResumeOfSaturdayComponent,
    OpponentComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
