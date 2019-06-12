# What's this  

## What is the 'What's this' Application?   

* 이제 막 언어를 배우는 아이들은 부모에게 사물의 명칭을 자주 물어보는 경우가 많습니다.  
하지만 이렇게 부모가 단어를 알려주게 되면 아이는 당시에 사물 명칭을 듣고 흘려 버릴 가능성이 매우 높습니다.  
따라서 이 어플의 목적은 아이의 부모가 단어를 한 번 알려주고 그치는 것이 아니라 그 단어를 저장하여 나중에 몰랐던 단어를 부모와 함께 찾아보며 공부를  할 수 있도록 도와주는 것입니다.  
또, 처음 사용법을 익히고 나면 나중에 아이 혼자 사진을 찍어 음성으로 들을 수 있도록 하여 흥미롭게 단어를 익힐 수 있도록 하였습니다.  

* App 사용 대상: 언어를 배우는 4-6세 아이들 및 어린 아이들의 부모 

## 다운로드 받기 전 필요한 부분  

* 이 어플리케이션을 구동하기 위해서는 웹 서버가 구축되어있어야 하고, 웹서버의 도메인 주소와 php파일명을 안드로이드 request class에 입력해 주어야 합니다.  
* 안드로이드 스튜디오 3.4.0 이상의 버전  
[Download link] (http://developer.android.com/studio/index.html)  
* Api level: 22 이상  
* 안드로이드 기기에서 카메라와 사진, 스피커의 접근성 허용  

## App 적용 주 기능  

* android studio TTS  
* dictionary  
* Tensorflow lite, Mobilenet 및 lnception 모델   
* 카메라 2 API를 사용하여 모바일 카메라 및 이미지 캡처와 상호 작용을 통해 이미지 인식  

## Tensorflow Object Detection api  

* Tensorflow object detection API는 사진에서 물체를 인식하는 모델을 쉽게 제작/학습/배포할 수 있는 오픈소스 프레임 워크입니다.  
  사물 인식은 매우 활발히 연구되고 빠르게 발전하는 모델로서, 2018년 기준 구글은 19개의 pre-trained object detection model을 공개했으며,  점점 더 많은 모델이 구현되고 공개될 것입니다.  
* Tensorflow lite는 각기 다른 정확도와 속도를 가지고 있는 5개의 모델을 제공 합니다.  
  머신러닝이나 텐서플로우에 대한 개념이 없더라도 라이브러리 형태로 손쉽게 사용할 수 있으며, 직접 사용자 데이터를 업로드 해 학습을 하여, 내 시나리오에 맞는 Object Detection System을 손쉽게 만들 수 있습니다.  

## Tensorflow lite와 TTS  

* Tensorflow lite는 Mobile, Embedded device와 같이 한정 된 자원을 갖는 디바이스에서 on-device learning을 하기 위한 경량화 된 솔루션이다. 짧은 대기 시간과 작은 바이너리 크기로 디바이스 내에서 기계학습 유추가 가능합니다.  
* TTS(Text to speech)는 컴퓨터 프로그램을 통해 텍스트를 음성으로 읽어 주는 것 입니다.  
* Tensorflow Lite와 TTS는 APP 기능 중 하나인 Detection에 사용 됩니다. Detection에서 모바일 카메라로 사물을 인식하고 캡처를 하면 캡처 된 이미지가 Bitmap 형태로 Classifirer에 전달해 분류 됩니다. 그 후 분류된 이미지를 Tensorflow Lite 통해 인식하고, 사물의 텍스트를 사용자에게 전달해 줍니다. 그 후 TTS는 사물의 텍스트를 음성으로 읽어 줍니다.  

## Database 연동  

* 안드로이드 스튜디오와 DB를 바로 연결 할 수 없기 때문에 PHP파일을 사용하여 안드로이드 스튜디오와 DB를 연결합니다.
* Register.php는 회원가입에 필요한 정보들을 데이터베이스에 저장합니다.  
* UserValidate.php는 아이디 중복을 확인합니다.  
* Login.php는 입력된 아이디와 비밀번호가 회원테이블에 존재하는지 확인후 로그인합니다.  
* Identi_ID.php는 회원가입 당시 입력했던 이메일이 회원테이블에 존재하는 확인하고 존재한다면 해당 이메일에 회원의 아이디를 전송합니다.  
* Identification.php는 입력받은 아이디를 회원테이블에서 확인후 값이 존재하면 해당 아이디 회원의 이메일주소로 인증번호를 전송합니다.  
* passwordChange.php는 회원의 비밀번호를 변경하는데 사용합니다.  
* withdraw.php는 회원탈퇴 기능을 구현합니다.  
* getjson.php는 마이페이지에 로그인된 회원의 아이디, 이름, 이메일을 출력할 때 Database에서 안드로이드로 데이터값들을 가져옵니다.  
* SaveWords.php는 인식된 단어를 로그인된 아이디와 함께 USER_WORD테이블에 저장합니다.  
* fetchWord.php는 회원이 저장한 단어들을 안드로이드로 전송합니다.

## 어플사용  

* Join을 통해 부모가 자녀 계정을 만듭니다.  
* 만들어 놓은 계정으로 로그인 시 자동 로그인이 가능해 다시 로그인을 해야 하는 번거로움이 없습니다.  
* Detection 메뉴로 들어가서 사진을 찍게되면 그 사물의 명칭을 결과 창에 띄어 줍니다.  
* 음성 버튼을 통해 사물의 이름을 TTS로 읽어주고 저장 버튼을 누르면 사용자 계정에 그 단어가 저장됩니다.  
* Dictionary는 Dictection의 기능을 사용하면서 학습중인 사용자가 모르는 단어가 생겼을 경우 검색을 통해 단어의 뜻을 익히고 사용자의 회원 정보 관리와 Detection에서 저장한 단어를 열람 할 수 있습니다.  
* My page 에서는 사용자의 회원 정보 열람 및 수정이 가능합니다.  
