using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace SOAExp1
{
    /// <summary>
    /// WebService1 的摘要说明
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // 若要允许使用 ASP.NET AJAX 从脚本中调用此 Web 服务，请取消注释以下行。 
    // [System.Web.Script.Services.ScriptService]
    public class WebService1 : System.Web.Services.WebService
    {

        [WebMethod]
        public string HelloWorld()
        {
            return "Hello World";
        }

        [WebMethod(Description = "电话按键转字母组合")]
        public string DigitsToLetter(string numbers)
        {
            foreach (var item in numbers)
            {
                if('2'>item || '9'<item)
                {
                    return "输入数字串有误!";
                }
            }
            List<string> resultList = new List<string>(); //字母组合List
            CombinationLetter(numbers, "", 0, resultList); //递归查找结果
            string resultString = ""; //List转字符串
            //拼接字符串
            int listCount = resultList.Count;
            for(int i=0;i<listCount;i++)
            {
                resultString += resultList[i];
                if(i < listCount-1)
                {
                    resultString += " ";
                }
            }
            return resultString;
        }

        /// <summary>
        /// 递归查找字母组合方法
        /// </summary>
        /// <param name="numbers"></param>
        /// <param name="letters"></param>
        /// <param name="nowIndex"></param>
        /// <param name="result"></param>
        private void CombinationLetter(string numbers, string letters, int nowIndex, List<string> result)
        {
            if (nowIndex >= numbers.Length)
            {
                result.Add(letters);
                return;
            }
            switch (numbers[nowIndex])
            {
                case '2':
                    CombinationLetter(numbers, letters+'a', nowIndex + 1, result);
                    CombinationLetter(numbers, letters+'b', nowIndex + 1, result);
                    CombinationLetter(numbers, letters+'c', nowIndex + 1, result);
                    break;
                case '3':
                    CombinationLetter(numbers, letters + 'd', nowIndex + 1, result);
                    CombinationLetter(numbers, letters + 'e', nowIndex + 1, result);
                    CombinationLetter(numbers, letters + 'f', nowIndex + 1, result);
                    break;
                case '4':
                    CombinationLetter(numbers, letters + 'g', nowIndex + 1, result);
                    CombinationLetter(numbers, letters + 'h', nowIndex + 1, result);
                    CombinationLetter(numbers, letters + 'i', nowIndex + 1, result);
                    break;
                case '5':
                    CombinationLetter(numbers, letters + 'j', nowIndex + 1, result);
                    CombinationLetter(numbers, letters + 'k', nowIndex + 1, result);
                    CombinationLetter(numbers, letters + 'l', nowIndex + 1, result);
                    break;
                case '6':
                    CombinationLetter(numbers, letters + 'm', nowIndex + 1, result);
                    CombinationLetter(numbers, letters + 'n', nowIndex + 1, result);
                    CombinationLetter(numbers, letters + 'o', nowIndex + 1, result);
                    break;
                case '7':
                    CombinationLetter(numbers, letters + 'p', nowIndex + 1, result);
                    CombinationLetter(numbers, letters + 'q', nowIndex + 1, result);
                    CombinationLetter(numbers, letters + 'r', nowIndex + 1, result);
                    CombinationLetter(numbers, letters + 's', nowIndex + 1, result);
                    break;
                case '8':
                    CombinationLetter(numbers, letters + 't', nowIndex + 1, result);
                    CombinationLetter(numbers, letters + 'u', nowIndex + 1, result);
                    CombinationLetter(numbers, letters + 'v', nowIndex + 1, result);
                    break;
                case '9':
                    CombinationLetter(numbers, letters + 'w', nowIndex + 1, result);
                    CombinationLetter(numbers, letters + 'x', nowIndex + 1, result);
                    CombinationLetter(numbers, letters + 'y', nowIndex + 1, result);
                    CombinationLetter(numbers, letters + 'z', nowIndex + 1, result);
                    break;
                default:
                    break;
            }
            return;
        }

        [WebMethod(Description = "查找指定日期从北京到长沙的所有航班,日期格式:yyyy-mm-dd")]
        public DataSet SearchAirLine(string date)
        {
            AirLine.DomesticAirlineSoapClient domesticAirline = new AirLine.DomesticAirlineSoapClient();
            return domesticAirline.getDomesticAirlinesTime("北京","长沙", date, null);
        }
    }


}
