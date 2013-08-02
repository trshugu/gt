/*
*/






/*
// GroovyBean
class Book
{
  String title  // �v���p�e�B�̐錾
}

def groovyBook = new Book()

// �����I�ȃ��\�b�h�Ăяo���ɂ��v���p�e�B�̗��p
groovyBook.setTitle('Groovy world')
assert groovyBook.getTitle() == 'Groovy world'

// Groovy�ɂ��V���[�g�J�b�g���g�����v���p�e�B�̗��p
groovyBook.title = 'No Groovy, No Life'
assert groovyBook.title == 'No Groovy, No Life'
*/

/*
Groovy�ł͈ȉ��̃p�b�P�[�W���ÖٓI�ɃC���|�[�g�ς�
java.io.*
java.lang.*
java.math.BigDecimal
java.math.BigInteger
java.net.*
java.util.*
groovy.lang.*
groovy.util.* 
*/

/*
[1, 2, 3].each { entry -> println entry }
[4, 5, 6].each { println it } // �p�����[�^�ȗ�����it�ŎQ�Ƃł���
[a: 100, b: 200, c: 300].each { key, value ->
  println "${key}=${value}"
}
*/


/*
// �͈�
def x = 1..10
assert x.contains(5)
assert x.contains(15) == false
assert x.size() == 10
assert x.from == 1
assert x.to == 10
assert x.reverse() == 10..1

def y = 1..<10
assert y.from == 1
assert y.to == 9
*/


/*
// �}�b�v��[]�ň͂݁A�u�L�[:�l�v�̌`�œ��e�������A�J���}�ŋ�؂�
def http = [
  100 : 'CONTINUE',
  200 : 'OK',
  400 : 'BAD REQUEST' ]
assert http[200] == 'OK'

http[500] = 'INTERNAL SERVER ERROR'
assert http.size() == 4
*/

/*
// ���X�g�A�}�b�v�A�͈�
def roman = ['', 'I', 'II', 'III', 'IV', 'V', 'VI', 'VII'] // ���[�}�����̃��X�g
assert roman[4] == 'IV' // ���X�g�ւ̃A�N�Z�X

roman[8] = 'VIII' // ���X�g�̊g��
assert roman.size() == 9
*/

/*
// Boolean�l�͎���
assert true
assert !false

// Matcher�̓}�b�`���邱��
assert ('a' =~ /./)
assert !('a' =~ /b/)

// �R���N�V�����͋�ł͂Ȃ�����
assert [1]
assert ![]

// �}�b�v�͋�ł͂Ȃ�����
assert ['a': 1]
assert ![:]

// ������͋�ł͂Ȃ�����
assert 'a'
assert !''

// ���l�i�ǂ̌^���j�̓[���ł͂Ȃ�����
assert 1
assert 1.1
assert 1.2f
assert 1.3g
assert 2L
assert 3G
assert !0

// ���̑��́A���ׂ�null�ł͂Ȃ�����
assert new Object()
assert !null
*/



/*
// return���ȗ��\ �ȗ������ꍇ�A�Ō�ɕ]�����ꂽ�l���ԋp�����
def method()
{
  def a = 10
  def b = 20
  a + b
}
assert method() == 30
*/

/*
// try-catch
try
{
  // ����
}
catch(e)
{
  // ��Oe����������
}
finally
{
  // �ŏI����
}
*/

/*
switch(3)
{
  case 1 : assert false; break
  case 3 : assert true;  break
  default: assert false
}
*/

/*
for (i = 0; i < 10; i++) // �̂Ȃ����for
{
  println i
}

def clinks = 0
for (remainingGuests in 0..9) // �͈͂ɑ΂���for
{
  clinks += remainingGuests 
}
println clinks

def list = [0, 1, 2, 3, 4, 5]
for (j in list) // ���X�g�ɑ΂���for
{
  assert j == list[j]
}
*/


/*
def i = 0
while (i < 10)
{
  i++
}
assert i == 10
*/

/*
if (false) assert false // �P��s��if

if (null) // null�͋U
{
  assert false
}
  else
{
  assert true
}
*/

/*
// assertion �^�̊Ԃ͎��s���Ă������N����Ȃ�
def a = 10
def b = 40
assert 30 == a + b, '��������30�̂͂�'
*/

/*
// sb��+�̑��x�̔�r�ő����ق� groovy����2�{�x������
// +�̏ꍇ
long start = System.currentTimeMillis();
int cnt = 0;
while (cnt < 100000)
{
String sql = "";
sql += " SELECT ";
sql += " TSV_ID, ";
sql += " COORDINAT_ID, ";
sql += " MAIL_ADDRESS_TO, ";
sql += " MAIL_ADDRESS_CC, ";
sql += " MAIL_ADDRESS_BCC, ";
sql += " LPAD(DELIVERY_TIME,6,0) DELIVERY_TIME, ";
sql += " MAIL_ADDRESS_FROM, ";
sql += " SUBJECT, ";
sql += " HEADER, ";
sql += " TEXT, ";
sql += " FOOTER ";
sql += " FROM ";
sql += " SEND_RANKING_MAIL_MANAGE ";
sql += " WHERE ";
sql += "  LPAD(DELIVERY_TIME,6,0) <=  ";
sql += " ORDER BY ";
sql += " TSV_ID ";
cnt++;
}
long end = System.currentTimeMillis();
long i = end - start;



// sb�̏ꍇ
long startsb = System.currentTimeMillis();
int cntsb = 0;
while (cntsb < 100000)
{
StringBuilder sbl = new StringBuilder();
sbl.append(" SELECT ")
.append( " TSV_ID, ")
.append( " COORDINAT_ID, ")
.append( " MAIL_ADDRESS_TO, ")
.append( " MAIL_ADDRESS_CC, ")
.append( " MAIL_ADDRESS_BCC, ")
.append( " LPAD(DELIVERY_TIME,6,0) DELIVERY_TIME, ")
.append( " MAIL_ADDRESS_FROM, ")
.append( " SUBJECT, ")
.append( " HEADER, ")
.append( " TEXT, ")
.append( " FOOTER ")
.append(" FROM ")
.append( " SEND_RANKING_MAIL_MANAGE ")
.append(" WHERE ")
.append("  LPAD(DELIVERY_TIME,6,0) <=  ")
.append(" ORDER BY ")
.append( " TSV_ID ");
cntsb++;
}
long endsb = System.currentTimeMillis();
long isb = endsb - startsb;


System.out.println(i);
System.out.println(isb);
*/



/*
// java����̗��p
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import javax.xml.xpath.*;

// xml�p�[�X�e�X�g
String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><rss xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" xmlns:dc=\"http://purl.org/dc/elements/1.1/\" xmlns:taxo=\"http://purl.org/rss/1.0/modules/taxonomy/\" version=\"2.0\">tetete</rss>";
try
{
  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
  DocumentBuilder db = dbf.newDocumentBuilder();
  InputSource is = new InputSource(new StringReader(xml));
  Document doc = db.parse(is);
  
  XPathFactory factory = XPathFactory.newInstance();
  XPath xpath = factory.newXPath();
  XPathExpression expr = xpath.compile("//rss/text()");
  Object result = expr.evaluate(doc, XPathConstants.STRING);
  
  System.out.println(result);
}
catch(Exception ex){}
*/



/*
// �f�t�H���g����
def greet(mess = "Hello World")
{
    println mess
}

greet()
greet("foo")
*/

/*
// for��
for (int i = 0; i < 3; i++) { println "$i: Hell1" }
for (i in 1..3) { println "$i: Hell2" }

(1..3).each { println "$it: Hell3" }
3.times { println "$it: Hell4" }
*/


/*
// switch/case�� �C�ӂ̌^�ɑ΂��ĕ���
//def value = 1
def value = "Hello"
switch (value)
{
  case "Hello": 
    println "value == 'Hello'"
    break
  case String: 
    println "value��String�^"
    break
  case 1..12: 
    println "value��1�`12�̊�"
    break
  default:
    println "����ȊO"
}
*/


/*
// �N���X��`
class HellTest
{
  public HellTest()
  {
    println "Hell, World!"
  }
  
  public static void main(String[] args)
  {
    new HellTest()
  }
}
*/


/*
// ������
import groovy.swing.SwingBuilder
import javax.swing.*
 
def notepad
new SwingBuilder().frame(
  title: "������",
  defaultCloseOperation: JFrame.EXIT_ON_CLOSE,
  size: [800, 600],
  show: true,
  locationRelativeTo: null)
{
  menuBar()
  {
    menu(text: "�t�@�C��(F)", mnemonic: 'F')
    {
      menuItem(
        text: "���O�����ĕۑ�(A)...",
        mnemonic: 'A',
        actionPerformed:
        {
          fc = new JFileChooser()
          if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
          {
            fc.selectedFile.text = notepad.text
          }
        }
      )
      
      menuItem(text: "�I��(X)", mnemonic: 'X', actionPerformed: { System.exit(0) })
    }
  }
  
  scrollPane() { notepad = textArea() }
}
*/


/*
// �N���[�W���e�X�g
def str = "clojure"
def readerClosure = {
ttt = "aaaa"
println str
println ttt
}
readerClosure()

def writerClosure = {
str = "foo" 
ttt = "bbb"
}
writerClosure()

println str
println ttt
readerClosure()
println ttt
*/

/*
// Meta Object Protocol
class Main
{
  static void main(String[] array)
  {
    // �C���X�^���X�쐬
    GroovyObject groovyObject = new Main()
    
    // ���\�b�h�pinterseptor�C���X�^���X�쐬
    Interceptor interceptor = new GreetingInterceptor()
    
    // Util�Ƀ��C���̃C���X�^���X�ƃ��\�b�h�C���X�^���X�𖄂ߍ���
    InterceptorUtils.setInterceptor(groovyObject, interceptor)
    
    // ���\�b�h���s
    groovyObject.greet()
  }
}

class InterceptorUtils
{
  // Object�Ƀ��\�b�h�𖄂ߍ���
  static void setInterceptor(GroovyObject groovyObject, Interceptor interceptor)
  {
    // �N���X���擾
    ProxyMetaClass proxyMetaClass = ProxyMetaClass.getInstance(groovyObject.getClass())
    // �擾�����N���X�̃C���X�^���X��impl�g�����\�b�h���Z�b�g
    proxyMetaClass.setInterceptor(interceptor)
    
    // �n���ꂽ�I�u�W�F�N�g�Ɋg�����\�b�h�𖄂ߍ��񂾃C���X�^���X���Z�b�g
    groovyObject.setMetaClass(proxyMetaClass)
  }
}

// �g����Impl Interseptor���p��
class InterceptorImpl implements Interceptor
{
  Object beforeInvoke(Object groovyExtensionObject, String name, Object[] arguments)
  {
    return null
  }
  
  Object afterInvoke(Object groovyExtensionObject, String name, Object[] arguments, Object be	eInvokeReturnObject)
  {
    Object object = invokeMethod(name, arguments)
    return object
  }
  
  boolean doInvoke()
  {
    return false
  }
}

// greet������Interceptor Impl���g��
class GreetingInterceptor extends InterceptorImpl
{
  void greet()
  {
    println "MOP"
  }
}
*/


/*
// expando�̗�2
def obj = [:]
obj.greetingMessage = "Hello World"
obj.greet = { println obj.greetingMessage }
obj.greet()
obj.message = "foo"
println obj.message
*/

/*
// expando�̗�
def obj = new Expando()
obj.greetingMessage = "Hello World"
obj.greet = { println greetingMessage }
obj.greet()
obj.message = "foo"
println obj.message
*/


/*
// get set�m�F
class Pojo {
  def name
}
def pojo = new Pojo(name:"���O")
println pojo.getName() // getName()����������Ă���
println pojo.name // getName()���Ă΂��
*/

/*
// groovy�e�X�g
println "Hell, World"
*/


