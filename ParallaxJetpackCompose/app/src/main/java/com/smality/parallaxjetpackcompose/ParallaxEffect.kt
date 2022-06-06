package com.smality.parallaxjetpackcompose

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import kotlin.math.*

@Composable
fun ParallaxEffect(scrollState: ScrollState) {
    val text = "Bartın il merkezine 17 km uzaklıkta, tarihle doğanın iç içe olduğu Güzelcehisar köyü, Karadeniz sahilinde orman alanları, denizi, kumu eşsiz gün batımı ile görenleri büyüleyen, görülmesi gereken önemli bir cazibe merkezidir. Güzelcehisar sahilinde bulunan ve 80 milyon yıllık olduğu tahmin edilen lav sütunları görsel bir şölen sunmaktadır. Güzelcehisar'ın 850 metre uzunluğundaki kumsalın batı ucundan başlayan ve denizden bir duvar gibi yükselen sütun yapılı lav kayalıkları deniz kıyısı boyunca uzanarak Mugada'ya kadar ulaşmaktadır.  \nTürkiye'de ise Bartın'ın tarih ve doğanın iç içe olduğu Güzelcehisar ilçesinde bulunan lav sütunları, \"Bartın İli Güzelcehisar Lav Sütunları ve Sahilinin Turizm ve Rekreasyon Amaçlı Peyzaj Uygulama Projesi\" kapsamında hazırlanan projeyle geçen yıl turizme kazandırıldı. Batı Karadeniz Kalkınma Ajansının (BAKKA) Mali Destek Programı kapsamında, İl Kültür ve Turizm Müdürlüğünün projesiyle uluslararası ölçekte turizme kazandırılması hedeflenen lav sütunları, projenin uygulanmasının ardından ziyaretçilerin uğrak noktalarından biri haline geldi."
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            TopAppBar(
                //TopAppBar alanındaki başlık stilinin tanımlanması
                title = {
                    Text(
                        text = "Bartın Lav Sütunları",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    )
                }
            )

            Column(
                //Y ekseninde scrolling yapabilmek için verticalScroll tanımlıyoruz
                modifier = Modifier
                   .verticalScroll(scrollState)
                    .fillMaxSize()
            ) {
                val height = 320.dp
                Image(
                    //Kullanılan resmi belirliyoruz.
                    painter = painterResource(id = R.drawable.image),
                    contentDescription = "Banner Image",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(height)
                        .graphicsLayer {
                            //kaydırma esnasında soluklaştırma görüntüsünü oluşturduğmuz bölüm
                            //scrollState ve height değerlerini matematiksel işlemlerle bu işlemi yapıyoruz.
                            alpha = min(
                                1f,
                                max(
                                    0.0f,
                                    1 - (scrollState.value / ((height.value * 2) + (height.value / 1.5f)))
                                )
                            )
                        }
                )
                //İçerik yazısıyla ilgili still özelliklerinin tanımlanması
                Text(
                    text = text,
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Serif,
                    modifier = Modifier.padding(10.dp),
                    style = TextStyle(
                        lineHeight = 25.sp,
                        textAlign = TextAlign.Justify
                    )
                )
            }
        }
    }
}
