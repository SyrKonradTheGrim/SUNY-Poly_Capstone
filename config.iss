; Script generated by the Inno Setup Script Wizard.
; SEE THE DOCUMENTATION FOR DETAILS ON CREATING INNO SETUP SCRIPT FILES!

#define MyAppName "PF2ECharacterCreator"
#define MyAppVersion "1.1"
#define MyAppPublisher "Janis Inc."
#define MyAppExeName "PF2ECharacterCreator.exe"

[Setup]
; NOTE: The value of AppId uniquely identifies this application. Do not use the same AppId value in installers for other applications.
; (To generate a new GUID, click Tools | Generate GUID inside the IDE.)
AppId={{B22942B0-E95B-4E81-B5F7-A5A4DFF5F476}
AppName={#MyAppName}
AppVersion={#MyAppVersion}
;AppVerName={#MyAppName} {#MyAppVersion}
AppPublisher={#MyAppPublisher}
DefaultDirName={autopf}\{#MyAppName}
DisableDirPage=yes
DisableProgramGroupPage=yes
LicenseFile=C:\Users\user\Desktop\Programs\Java\PathfinderCharacterCreator\README.txt
; Uncomment the following line to run in non administrative install mode (install for current user only.)
;PrivilegesRequired=lowest
OutputDir=C:\Users\user\Desktop
OutputBaseFilename=PF2EInstaller
Compression=lzma
SolidCompression=yes
WizardStyle=modern

[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"

[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked

[Files]
Source: "C:\Users\user\Desktop\Programs\Java\PathfinderCharacterCreator\PF2ECharacterCreator.exe"; DestDir: "{app}"; Flags: ignoreversion
Source: "C:\Users\user\Desktop\Programs\Java\PathfinderCharacterCreator\JRE\*"; DestDir: "C:\Program Files (x86)\PF2ECharacterCreator\JRE"; Flags: recursesubdirs createallsubdirs
Source: "C:\Users\user\Desktop\Programs\Java\PathfinderCharacterCreator\characters\*"; DestDir: "C:\Program Files (x86)\PF2ECharacterCreator\characters"; Flags: recursesubdirs createallsubdirs
Source: "C:\Users\user\Desktop\Programs\Java\PathfinderCharacterCreator\info\*"; DestDir: "C:\Program Files (x86)\PF2ECharacterCreator\info"; Flags: recursesubdirs createallsubdirs
; NOTE: Don't use "Flags: ignoreversion" on any shared system files

[Icons]
Name: "{autoprograms}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"
Name: "{autodesktop}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"; Tasks: desktopicon

[Run]
Filename: "{app}\{#MyAppExeName}"; Description: "{cm:LaunchProgram,{#StringChange(MyAppName, '&', '&&')}}"; Flags: nowait postinstall skipifsilent

