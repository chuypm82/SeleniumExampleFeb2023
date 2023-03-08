; Wait 10 seconds for the Upload window to appear

WinWait("[CLASS:Chrome_WidgetWin_1]","",10)

; Set input focus to the edit control of Upload window using the handle returned by WinWait

ControlFocus ( "https://the-internet.herokuapp.com/basic_auth - Google Chrome", "", "Intermediate D3D Window1")
Sleep(2000)

; Set the File name text on the Edit field

 ControlSetText("https://the-internet.herokuapp.com/basic_auth - Google Chrome", "", "Intermediate D3D Window1", "admin")
 Sleep(2000)

 ; Click on the Open button

;ControlClick("https://the-internet.herokuapp.com/basic_auth - Google Chrome", "","Button1");
