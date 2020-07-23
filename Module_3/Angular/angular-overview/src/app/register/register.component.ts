import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
function comparePassword(c: AbstractControl)  {
  const v = c.value;
    return (v.password === v.confirmPassword) ? null : {
      passwordnotmatch: true
    };
}
function comparePassword2(c: AbstractControl) {
  const v = c.value;
    return (v.password === 'aaaa') ? null : {
      ngu: true
    };
}
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})

export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    this.registerForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      pwGroup: this.fb.group({
        password: ['', [Validators.required, Validators.minLength(6)]],
        confirmPassword: ['', [Validators.required, Validators.minLength(6)]]
      },
      {validators: [comparePassword2, comparePassword]}),
      country: ['', Validators.required],
      age: ['', [Validators.required, Validators.min(18)]],
      gender: ['', Validators.required],
      phone: ['', [Validators.required, Validators.pattern(/^\+84\d{9,10}$/)]]
    });

    // update form state
    this.registerForm.patchValue({
      email: 'info@example.com'
    });
  }
  onSubmit() {
    console.log(this.registerForm);
  }

}