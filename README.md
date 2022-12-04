# ViewTreeLifecycleOwnerDialogBug

This repo contains a reproduction of an issue with the AppCompatDialog & Componentdialog. It shows that the ComponentDialog does not set the ViewLifecycleTreeOwner correctly when setContentView is called. AppCompatDialog (the subclass of ComponentDialog) does not call super.setContentView and instead calls a delegate which never reaches ComponentDialog.

See MyDialog.kt

```
button?.setOnClickListener {
      // setContentView above should have reached ComponentDialog to initialize the ViewTreeLifeCycleOwner
      ViewTreeLifecycleOwner.get(view)!! // causes crash
    }
```
