/*
*/






/*
// GroovyBean
class Book
{
  String title  // プロパティの宣言
}

def groovyBook = new Book()

// 明示的なメソッド呼び出しによるプロパティの利用
groovyBook.setTitle('Groovy world')
assert groovyBook.getTitle() == 'Groovy world'

// Groovyによるショートカットを使ったプロパティの利用
groovyBook.title = 'No Groovy, No Life'
assert groovyBook.title == 'No Groovy, No Life'
*/

/*
Groovyでは以下のパッケージが暗黙的にインポート済み
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
[4, 5, 6].each { println it } // パラメータ省略時はitで参照できる
[a: 100, b: 200, c: 300].each { key, value ->
  println "${key}=${value}"
}
*/


/*
// 範囲
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
// マップも[]で囲み、「キー:値」の形で内容を示し、カンマで区切る
def http = [
  100 : 'CONTINUE',
  200 : 'OK',
  400 : 'BAD REQUEST' ]
assert http[200] == 'OK'

http[500] = 'INTERNAL SERVER ERROR'
assert http.size() == 4
*/

/*
// リスト、マップ、範囲
def roman = ['', 'I', 'II', 'III', 'IV', 'V', 'VI', 'VII'] // ローマ数字のリスト
assert roman[4] == 'IV' // リストへのアクセス

roman[8] = 'VIII' // リストの拡大
assert roman.size() == 9
*/

/*
// Boolean値は自明
assert true
assert !false

// Matcherはマッチすること
assert ('a' =~ /./)
assert !('a' =~ /b/)

// コレクションは空ではないこと
assert [1]
assert ![]

// マップは空ではないこと
assert ['a': 1]
assert ![:]

// 文字列は空ではないこと
assert 'a'
assert !''

// 数値（どの型も）はゼロではないこと
assert 1
assert 1.1
assert 1.2f
assert 1.3g
assert 2L
assert 3G
assert !0

// その他は、すべてnullではないこと
assert new Object()
assert !null
*/



/*
// returnが省略可能 省略した場合、最後に評価された値が返却される
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
  // 処理
}
catch(e)
{
  // 例外e発生時処理
}
finally
{
  // 最終処理
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
for (i = 0; i < 10; i++) // 昔ながらのfor
{
  println i
}

def clinks = 0
for (remainingGuests in 0..9) // 範囲に対するfor
{
  clinks += remainingGuests 
}
println clinks

def list = [0, 1, 2, 3, 4, 5]
for (j in list) // リストに対するfor
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
if (false) assert false // 単一行のif

if (null) // nullは偽
{
  assert false
}
  else
{
  assert true
}
*/

/*
// assertion 真の間は実行しても何も起こらない
def a = 10
def b = 40
assert 30 == a + b, '足したら30のはず'
*/

/*
// sbと+の速度の比較で多いほう groovyだと2倍遅かった
// +の場合
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



// sbの場合
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
// javaからの流用
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import javax.xml.xpath.*;

// xmlパーステスト
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
// デフォルト引数
def greet(mess = "Hello World")
{
    println mess
}

greet()
greet("foo")
*/

/*
// for文
for (int i = 0; i < 3; i++) { println "$i: Hell1" }
for (i in 1..3) { println "$i: Hell2" }

(1..3).each { println "$it: Hell3" }
3.times { println "$it: Hell4" }
*/


/*
// switch/case文 任意の型に対して分岐
//def value = 1
def value = "Hello"
switch (value)
{
  case "Hello": 
    println "value == 'Hello'"
    break
  case String: 
    println "valueはString型"
    break
  case 1..12: 
    println "valueは1～12の間"
    break
  default:
    println "それ以外"
}
*/


/*
// クラス定義
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
// メモ帳
import groovy.swing.SwingBuilder
import javax.swing.*
 
def notepad
new SwingBuilder().frame(
  title: "メモ帳",
  defaultCloseOperation: JFrame.EXIT_ON_CLOSE,
  size: [800, 600],
  show: true,
  locationRelativeTo: null)
{
  menuBar()
  {
    menu(text: "ファイル(F)", mnemonic: 'F')
    {
      menuItem(
        text: "名前をつけて保存(A)...",
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
      
      menuItem(text: "終了(X)", mnemonic: 'X', actionPerformed: { System.exit(0) })
    }
  }
  
  scrollPane() { notepad = textArea() }
}
*/


/*
// クロージャテスト
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
    // インスタンス作成
    GroovyObject groovyObject = new Main()
    
    // メソッド用interseptorインスタンス作成
    Interceptor interceptor = new GreetingInterceptor()
    
    // Utilにメインのインスタンスとメソッドインスタンスを埋め込む
    InterceptorUtils.setInterceptor(groovyObject, interceptor)
    
    // メソッド実行
    groovyObject.greet()
  }
}

class InterceptorUtils
{
  // Objectにメソッドを埋め込む
  static void setInterceptor(GroovyObject groovyObject, Interceptor interceptor)
  {
    // クラスを取得
    ProxyMetaClass proxyMetaClass = ProxyMetaClass.getInstance(groovyObject.getClass())
    // 取得したクラスのインスタンスにimpl拡張メソッドをセット
    proxyMetaClass.setInterceptor(interceptor)
    
    // 渡されたオブジェクトに拡張メソッドを埋め込んだインスタンスをセット
    groovyObject.setMetaClass(proxyMetaClass)
  }
}

// 拡張元Impl Interseptorを継承
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

// greetをもつInterceptor Implを拡張
class GreetingInterceptor extends InterceptorImpl
{
  void greet()
  {
    println "MOP"
  }
}
*/


/*
// expandoの例2
def obj = [:]
obj.greetingMessage = "Hello World"
obj.greet = { println obj.greetingMessage }
obj.greet()
obj.message = "foo"
println obj.message
*/

/*
// expandoの例
def obj = new Expando()
obj.greetingMessage = "Hello World"
obj.greet = { println greetingMessage }
obj.greet()
obj.message = "foo"
println obj.message
*/


/*
// get set確認
class Pojo {
  def name
}
def pojo = new Pojo(name:"名前")
println pojo.getName() // getName()が生成されている
println pojo.name // getName()が呼ばれる
*/

/*
// groovyテスト
println "Hell, World"
*/


