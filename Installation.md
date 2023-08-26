### JDK17 다운
- 다운로드 링크 : https://www.oracle.com/java/technologies/downloads/#jdk17-mac
<img width="846" alt="image" src="https://github.com/YeJi222/java-study/assets/70511859/a1d3ab53-1fb1-457f-9523-a22916acd71e">

- ARM64 DMG Installer dmg 버전으로 다운   
https://download.oracle.com/java/17/latest/jdk-17_macos-aarch64_bin.dmg
- dmg 설치 후, 아래 경로에 저장된다
```sh
/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home
```

### 이클립스 JRE 설정
- Eclipse -> Preferences -> (Java > Installed JRES)
<img width="501" alt="image" src="https://github.com/YeJi222/java-study/assets/70511859/14d57de7-2069-40fe-b07a-1f742124a718">

- Add -> Standard VM -> JRE home 추가    
/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home 경로 추가
<img width="579" alt="image" src="https://github.com/YeJi222/java-study/assets/70511859/4c40a610-1c6d-4b35-aad1-a42b2561a62a">

- 체크하고 Apply
<img width="442" alt="image" src="https://github.com/YeJi222/java-study/assets/70511859/a25e9ec1-8ae3-4164-be36-1b0b5b108a14">

### 톰캣 설치
<img width="487" alt="image" src="https://github.com/YeJi222/java-study/assets/70511859/8ffc0d4c-a800-412c-a504-6a04c538378b">

- zip으로 다운   
https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.80/bin/apache-tomcat-9.0.80.zip
