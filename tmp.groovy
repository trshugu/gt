/*
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


