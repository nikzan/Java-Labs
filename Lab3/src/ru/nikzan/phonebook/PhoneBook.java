// FIXME: отсутствует лицензия (п. 3.1) и глобальные отступы должны быть 2 пробела вместо 4 (п. 4.2)
// FIXTO:
/*
 * Copyright (c) 2026 Nikita Zanadvornykh
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package ru.nikzan.phonebook;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

// FIXME: отсутствует обязательный Javadoc публичного класса (п. 7.3)
//public class PhoneBook {
// FIXTO:
/**
 * Телефонный справочник, хранящий пары "имя-телефон".
 */
public class PhoneBook {
  private Map<String, String> contacts;

  /**
   * Инициализирует пустой телефонный справочник.
   */
  public PhoneBook() {
    this.contacts = new HashMap<>();
  }

  /**
   * Добавляет или обновляет контакт в справочнике.
   *
   * @param phone телефон
   * @param name имя контакта
   * @return старый телефон, если контакт с таким именем уже был, иначе null
   */
  public String add(String phone, String name) {
    return contacts.put(name, phone);
  }

  public void remove(String name) {
    contacts.remove(name);
  }

  public String get(String name) {
    return contacts.get(name);
  }

  public boolean containsPhone(String phone) {
    return contacts.containsValue(phone);
  }

  public boolean containsName(String name) {
    return contacts.containsKey(name);
  }

  public int size() {
    return contacts.size();
  }

  public String[] getAllPairs() {
    String[] pairs = new String[contacts.size()];
    int i = 0;
    for (Map.Entry<String, String> entry : contacts.entrySet()) {
      pairs[i++] = entry.getValue() + " - " + entry.getKey();
    }
    return pairs;
  }

  public String[] getAllPhones() {
    return contacts.values().toArray(new String[0]);
  }

  public String[] getAllNames() {
    return contacts.keySet().toArray(new String[0]);
  }

  /**
   * Возвращает имена контактов, начинающихся с указанного префикса.
   *
   * @param prefix префикс для поиска
   * @return массив совпавших имен
   */
  public String[] getNamesByPrefix(String prefix) {
    List<String> result = new ArrayList<>();
    for (String name : contacts.keySet()) {
      if (name.startsWith(prefix)) {
        result.add(name);
      }
    }
    return result.toArray(new String[0]);
  }

  @Override
  public String toString() {
    if (contacts.isEmpty()) {
      return "Справочник пуст";
    }
    
    StringBuilder sb = new StringBuilder("Телефонный справочник:\n");
    for (Map.Entry<String, String> entry : contacts.entrySet()) {
      sb.append(entry.getValue()).append(" - ").append(entry.getKey()).append("\n");
    }
    return sb.toString();
  }
}