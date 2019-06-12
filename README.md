# What's this  

## What is the 'What's this' Application?   

* 선정 배경 및 목적  
현재 모바일 퍼스트 시대에서 모바일 온리 시대가 도래 하고 있습니다. 그만큼 최근 10여년 동안 모바일 기술이 급속도로 발전해왔고, 주 사용 연령층 또한 광범위 해져 가고 있습니다.  
따라서, 광범위 해진 연령층에 일부인 유아들에게 교육을 흥미롭게 하는 도움을 주자하는 생각에서 주제를 선정하였습니다.

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
* 서버 구축   
![1](https://user-images.githubusercontent.com/48505700/59361264-880c4280-8d6c-11e9-80e7-0749c1c4ecb0.JPG)  
  cafe24에서 호스팅된 서버를 이용합.  
* 서버 관리 bitvise 설치  
  [Download link] (https://www.bitvise.com/ssh-client-download)  
  설치방법:  
   [Download link] (https://blog.naver.com/PostView.nhn?blogId=harry5313&logNo=221429902704&categoryNo=0&parentCategoryNo=0&viewDate=&currentPage=1&postListTopCurrentPage=1&from=postView)  
   ![2](https://user-images.githubusercontent.com/48505700/59361273-8c386000-8d6c-11e9-8bd9-6347dd759b3c.JPG)  
     
 * 서버 php파일관리  
   sublime text설치 및 사용  
    [Download link] (https://www.sublimetext.com/3)  
    - sublime text는 php파일 편집 및 작성하는데 사용됩니다.  
    - php파일과 안드로이드 스튜디오 코드 회원가입코드  
 


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
  
## Tensorflow lite  

* Tensorflow 모델을 모바일, 임베디드, IoT 디바이스 등에서 실행하기 위한 툴입니다.  
  Tensorflow lite는 각기 다른 정확도와 속도를 가지고 있는 5개의 모델을 제공 합니다.  
* Tensorflow Lite 목적 : 단순히 모델 훈련이 아닌 모바일 환경에서 낮은 복잡도와 적은 용량의 모델 구동입니다.  
* Tensorflow Lite의 장점 : 낮은 지연시간, 작은 바이너리 크기, 디바이스 상에서의 머신러닝 추론 가능합니다.  
머신러닝이나 텐서플로우에 대한 개념이 없더라도 라이브러리 형태로 손쉽게 사용할 수 있습니다.  
직접 사용자 데이터를 업로드 해 학습을 하여, 내 시나리오에 맞는 Object Detection System을 손쉽게 만들 수 있습니다.  

![co](https://user-images.githubusercontent.com/48505700/59355648-54c4b600-8d62-11e9-9b11-64ec2c4f1e4f.jpg)  
  
  
## Tensorflow 구현  

#### Executor thread 사용  

![dd](https://user-images.githubusercontent.com/48505700/59356022-095ed780-8d63-11e9-856b-a5eaecd239f2.jpg)  
  
* Executor 프레임웍은 다음과 같은 특징을 갖습니다.  
1. 쓰레드 풀을 사용합니다.  
2. 무거운 쓰레드는 미리 할당 가능합니다.  
3. 태스크와 쓰레드를 생성하고 관리하는 것을 분리합니다.  
4. 쓰레드 풀안의 쓰레드는 한번해 하나씩 여러 태스크를 실행합니다.  
5. 태스크 큐를 이용해 태스크를 관리합니다.  
6. Executor Service를 더이상 필요 없으면 중지합니다.  
7. Executor Service가 멈추면 모든 쓰레드도 중지합니다.  
  
* asset폴더에 있는 tensorflow lite 라이브러리 변수에 정의합니다.  
  
  
![1](https://user-images.githubusercontent.com/48505700/59356550-031d2b00-8d64-11e9-9bde-57015725fb65.jpg)  
![2](https://user-images.githubusercontent.com/48505700/59356569-0a443900-8d64-11e9-9590-fb6107fb2540.jpg)  
  
미리 정의 한 excutor thread를 run하여 Classifier에 tensorflow 모델 전달 합니다.  
   
   
 ![3](https://user-images.githubusercontent.com/48505700/59356575-0fa18380-8d64-11e9-8073-8bc6942347ab.jpg)  
   
분류가 완료 되었을 시 Claasifier를 닫습니다.  

![4](https://user-images.githubusercontent.com/48505700/59356583-162ffb00-8d64-11e9-84a4-87678f56d4c4.jpg)  
  
* Camera  
  
 Camera 2의 API는 사용자가 직접 작성한 포맷으로 미처리의 화소 데이터를 캡처 할 수 있습니다.  
 oncreate 함수에서 Manifest파일에 camera permission이 허용되어 있는 지 확인 후  
   
 ![1](https://user-images.githubusercontent.com/48505700/59357516-f39ee180-8d65-11e9-9829-3197e71450b4.jpg)  
   
  camera를 실행합니다.  
  TextureView가 사용이 가능하다면 카메라를 실행합니다.  
 
 ![2](https://user-images.githubusercontent.com/48505700/59357535-fa2d5900-8d65-11e9-94db-ad6750435db2.jpg)  
  
  camera2의 여러 클래스  
    
  Camera를 켜기 위해 OpenCamera를 사용했습니다.
    
  ![3](https://user-images.githubusercontent.com/48505700/59357543-00233a00-8d66-11e9-952a-dc9e9f0b0aef.jpg)  
      
        
  ![4](https://user-images.githubusercontent.com/48505700/59357558-06b1b180-8d66-11e9-975a-54366fb805cb.jpg)  
  
  CameraDevice는 Camera 기기를 나타내고 CameraManager는 Camera의 기능을 시키는 요소입니다.  
    
    
    
  ![5](https://user-images.githubusercontent.com/48505700/59357571-0ca79280-8d66-11e9-9346-b2c1e078f316.jpg)    
  
  캡쳐 버튼에 onclick을 통해 takePicture method를 실행합니다.  
  
  ![6](https://user-images.githubusercontent.com/48505700/59357595-14673700-8d66-11e9-90ec-710c98c87f97.jpg)  
  ![7](https://user-images.githubusercontent.com/48505700/59357601-1a5d1800-8d66-11e9-814b-694779eeb951.jpg)     
  ![8](https://user-images.githubusercontent.com/48505700/59357618-20eb8f80-8d66-11e9-9f3b-ba8447ced251.jpg)  
    
 
## Tensorflow lite와 TTS  

* Tensorflow lite는 Mobile, Embedded device와 같이 한정 된 자원을 갖는 디바이스에서 on-device learning을 하기 위한 경량화 된 솔루션입니다
. 짧은 대기 시간과 작은 바이너리 크기로 디바이스 내에서 기계학습 유추가 가능합니다.    
* 이미지를 bitmap 형태로 변환하여 classifier.recognizeImage에 전달해 인식 결과를 저장합니다.  
 그 후 결과를 String형으로 변환해 결과창에 출력합니다.  
   
![1](https://user-images.githubusercontent.com/48505700/59358999-893b7080-8d68-11e9-8219-239748e4f288.jpg)  
  
 이미지 인식 메소드 안에 TTS변환 버튼의 onclicklistener를 달아 버튼 클릭시 음성 변환이 가능하게 합니다.  
   
 ![2](https://user-images.githubusercontent.com/48505700/59359010-90fb1500-8d68-11e9-8249-9a4a1096b721.jpg)  
   
 마지막으로 UiThread를 통해 카메라 미리보기와 인식 결과를 띄워줍니다.  
     
![3](https://user-images.githubusercontent.com/48505700/59359018-95273280-8d68-11e9-8a15-e3772684a72e.jpg)  
  
  ondestroy에서 카메라와 background에서 진행하던 카메라, tensorflow 모두 실행 중지 시켜줍니다. 또한 TTS도 실행 중지 시켜 앱 실행을 멈춘 후에도 다시 TTS가 실행 될 수 있게 합니다.  
    
    
 ![4](https://user-images.githubusercontent.com/48505700/59359028-99535000-8d68-11e9-87c0-9b434cd56e30.jpg)  
      
 * TTS  
 TTS(Text to Speech)  
음성합성 시스템 : 컴퓨터의 프로그램을 통해 사람의 목소리를 구현해내는 것입니다.  
TTS 활용 : 운전 중 문자를 읽음, 시각 장애인을 위한 안내 음성으로 활용 합니다.  
  
 ![5](https://user-images.githubusercontent.com/48505700/59359046-9f493100-8d68-11e9-95c0-e8cae643b6d7.jpg)  
  
 oncreate에 TTS실행을 위한 기본 속성을 설정합니다. (ex. 읽는 속도, 언어)    
   
 ![6](https://user-images.githubusercontent.com/48505700/59359070-a708d580-8d68-11e9-9c88-4d03cda1cea9.jpg)  
   
 android SDK 버전에 따른 구분을 주어 오류를 제어합니다.  
 ![7](https://user-images.githubusercontent.com/48505700/59359078-abcd8980-8d68-11e9-8707-7ac309d42b14.jpg)  
   
   
## Database 연동  

* 안드로이드 스튜디오와 DB를 바로 연결 할 수 없기 때문에 PHP파일을 사용하여 안드로이드 스튜디오와 DB를 연결합니다.
* Register.php는 회원가입에 필요한 정보들을 안드로이드 스튜디오에서 받아 데이터베이스에 저장합니다.  
  
  registerButton 부분  
  ![3](https://user-images.githubusercontent.com/48505700/59361279-9195aa80-8d6c-11e9-8b1a-3d08d760655d.JPG)  
    
   RegisterRequest 코드  
   ![4](https://user-images.githubusercontent.com/48505700/59361301-98bcb880-8d6c-11e9-8449-8b5ac9bd210d.JPG)  
     
   Register.php 코드  
   ![5](https://user-images.githubusercontent.com/48505700/59361309-9d816c80-8d6c-11e9-9c10-69a22138931c.JPG)  
     
     
* UserValidate.php는 아이디 중복을 확인합니다.  
* Login.php는 입력된 아이디와 비밀번호가 회원테이블에 존재하는지 확인후 로그인합니다.  
  
  Login.php   
  ![12](https://user-images.githubusercontent.com/48505700/59361410-c3a70c80-8d6c-11e9-9b46-0021755181eb.JPG)  
    
안드로이드에서 POST방식으로 받아온 아이디와 비밀번호 값을 SQL문을 이용해 PHP에서 회원인지 아닌지 검사하고 TRUE값을 안드로이드로 전송합니다.  
  
  
  ### 자동로그인  
  * SharedPreferences는 DB를 사용하기 애매한 경우에 유용한 API.  
  * LoginActivity에서 조건문을 주어 SharedPreferences에 일정한 값이 저장되어있으면 MenuActivity로 이동합니다.  
  * 처음에는 SharedPreferences에 어떤 정보도 없으므로 값을 저장할 키들을 생성합니다.  
  * getString(）의 첫 번째 인자는 저장될 키, 두 번째 인자는 값 입니다.  
  * 키는 원하는 것으로 설정하고, 값은 null을 줍니다.  
    
    
    ![1](https://user-images.githubusercontent.com/48505700/59365820-2d76e480-8d74-11e9-9690-75ad960757cc.PNG)
     
       
  * LoginActivity로 들어왔을 때 loginID와 loginPW값을 가져와서 null이 아니면 (첫 로그인이 아닌 경우) 자동 로그인이 되어 MenuActivity가 실행됩니다.  
    
    
![2](https://user-images.githubusercontent.com/48505700/59365827-31a30200-8d74-11e9-9854-8e73a591a2c6.PNG)  
  
  
 * loginID값과 loginPW값이 둘 다 null인 경우(최초 로그인) SharedPreferences.Editor를 통해 auto의 loginID와 loginPW에 값을 저장합니다.  
   이때 저장된 loginID값과 loginPW값으로 앱을 재실행 시 자동로그인이 구현됩니다.  
     
     
 ![3](https://user-images.githubusercontent.com/48505700/59365836-3667b600-8d74-11e9-95a8-50a9b15822d7.PNG)  
   
   
    
  ### 로그아웃  
    
 * 로그아웃 버튼을 클릭하면 SharedPreferences에 저장된 정보를 삭제하기 위해 SharedPreferences를 LoginActivity에서 만든 이름으로 불러온다. 
 * editor.clear()를 사용해 auto에 들어있는 모든 정보를 기기에서 지운다.  
 * Intent를 사용해 LoginActivity로 돌아간다.  
    
    
![4](https://user-images.githubusercontent.com/48505700/59365845-3b2c6a00-8d74-11e9-9258-89b4782b7936.PNG)  
  
  
 
* Identi_ID.php는 회원가입 당시 입력했던 이메일이 회원테이블에 존재하는 확인하고 존재한다면 해당 이메일에 회원의 아이디를 전송합니다.  
* Identification.php는 입력받은 아이디를 회원테이블에서 확인후 값이 존재하면 해당 아이디 회원의 이메일주소로 인증번호를 전송합니다.  
  
  
  이메일로 인증번호 보내는 코드  
  ![8](https://user-images.githubusercontent.com/48505700/59361352-b12cd300-8d6c-11e9-8215-d0d9f9fc2a38.JPG)  
  ![9](https://user-images.githubusercontent.com/48505700/59361371-b558f080-8d6c-11e9-920f-e4809b632f8a.JPG)  
    
   Identification.php파일 (이메일 인증코드)  
   ![10](https://user-images.githubusercontent.com/48505700/59361384-b9850e00-8d6c-11e9-9cfd-018dbcb41ba2.JPG)  
     
   인증번호 메일 받은 결과  
   ![11](https://user-images.githubusercontent.com/48505700/59361392-bdb12b80-8d6c-11e9-9129-3fcaffe1ab92.JPG)  
      
      
* passwordChange.php는 회원의 비밀번호를 변경하는데 사용합니다.  
* withdraw.php는 회원탈퇴 기능을 구현합니다.  
* getjson.php는 마이페이지에 로그인된 회원의 아이디, 이름, 이메일을 출력할 때 Database에서 안드로이드로 데이터값들을 가져옵니다.  
* SaveWords.php는 인식된 단어를 로그인된 아이디와 함께 USER_WORD테이블에 저장합니다.  
* fetchWord.php는 회원이 저장한 단어들을 안드로이드로 전송합니다.  
  
  
  단어가져오는 getData()메소드  
  ![6](https://user-images.githubusercontent.com/48505700/59361319-a2deb700-8d6c-11e9-9508-eaa2d7f0e220.JPG)  
    
  단어가져오는 fetchWord.php 파일  
  ![7](https://user-images.githubusercontent.com/48505700/59361338-ac681f00-8d6c-11e9-8e7d-203909bace18.JPG)  
    
 ### Dictionary Api  
  OXFORD Dictionary api 사용  
  Oxford dictionary : 영국 옥스포드 대학교의 영어사전  
  최근 온라인 사전 수요 증가 추세로 인터넷, 휴대폰 등에서 사전탑재 환경 구축이 활발해졌습니다.  
    
 * OXFORD Dictionary api 사용법  
 [Download link] (https://developer.oxforddictionaries.com) 에서 prototype api key를 생성함과
 동시에 회원가입 -> 회원가입한 계정으로 로그인 시 application ID가 발급되어 있습니다.  
   
   ![1](https://user-images.githubusercontent.com/48505700/59366875-f7d2fb00-8d75-11e9-8b1b-0c50ec31e4e8.jpg)  
     
   로그인 후 메뉴 -> documentation -> V2 swagger docs -> 밑으로 스크롤  
     
   ![2](https://user-images.githubusercontent.com/48505700/59366892-002b3600-8d76-11e9-9090-e1e09ff019bf.jpg)  
     
   get /entries/{source_lang}/{word_id} 클릭
     
   ![3](https://user-images.githubusercontent.com/48505700/59366904-04efea00-8d76-11e9-9cb5-1cd4b429d122.jpg)  
     
   android studio app id, app key등록  
     
   ![4](https://user-images.githubusercontent.com/48505700/59366915-091c0780-8d76-11e9-815a-49ff8f42f797.jpg)  
   ![5](https://user-images.githubusercontent.com/48505700/59366925-0f11e880-8d76-11e9-9b16-c960608b5e4d.jpg)  
      
   my_app_id 와 key에 코드 아래 발급 받은 키와 id를 입력합니다.  
     
   ![6](https://user-images.githubusercontent.com/48505700/59366935-13d69c80-8d76-11e9-9036-21a2ee17d1b1.jpg)  
     
   AndroidManifest.xml파일에 인터넷 퍼미션 추가  
     
   ![7](https://user-images.githubusercontent.com/48505700/59366949-1a651400-8d76-11e9-9402-8a73594f3716.jpg)  
     
   url 정의  
     
   ![8](https://user-images.githubusercontent.com/48505700/59366964-205af500-8d76-11e9-90c9-56c6b0b689a0.jpg)  
     
   결과 요청  
     
   ![9](https://user-images.githubusercontent.com/48505700/59366973-24871280-8d76-11e9-9c0d-12dc895794ff.jpg)  
     
   결과 받아오기( JsonArray 형태 )  
     
   ![10](https://user-images.githubusercontent.com/48505700/59366981-28b33000-8d76-11e9-99fe-48932d4c4785.jpg)  
     
      
## 어플사용  

* Join을 통해 부모가 자녀 계정을 만듭니다.  
* 만들어 놓은 계정으로 로그인 시 자동 로그인이 가능해 다시 로그인을 해야 하는 번거로움이 없습니다.  
* Detection 메뉴로 들어가서 사진을 찍게되면 그 사물의 명칭을 결과 창에 띄어 줍니다.  
* 음성 버튼을 통해 사물의 이름을 TTS로 읽어주고 저장 버튼을 누르면 사용자 계정에 그 단어가 저장됩니다.  
* Dictionary는 Dictection의 기능을 사용하면서 학습중인 사용자가 모르는 단어가 생겼을 경우 검색을 통해 단어의 뜻을 익히고 사용자의 회원 정보 관리와 Detection에서 저장한 단어를 열람 할 수 있습니다.  
* My page 에서는 사용자의 회원 정보 열람 및 수정이 가능합니다.  
* youtube 어플 사용 영상 link (https://www.youtube.com/watch?v=sKjru0kjZ6k&feature=share)  
## 기대효과  

* 정보 통신 시대에 걸맞는 기술을 아이들이 자연스레 접할 수 있고, 시간과 장소에 구애 받지 않고 자기주도 학습이 가능합니다.  
