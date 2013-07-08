/*
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
  
  Object afterInvoke(Object groovyExtensionObject, String name, Object[] arguments, Object beforeInvokeReturnObject)
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


