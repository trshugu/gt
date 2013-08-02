/*
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


