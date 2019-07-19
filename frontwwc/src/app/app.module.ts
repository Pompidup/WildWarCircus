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
import { RegisterComponent } from './register/register.component';
import { AuthService } from './services/auth.service';
import { LoginComponent } from './login/login.component';

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
    RegisterComponent,
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
  providers: [AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
