#ifndef _CHAT_U_VOLCHAT__STRINGS_HPP_
#define _CHAT_U_VOLCHAT__STRINGS_HPP_

#include <string>
#include <sstream>

namespace com {
namespace uosipa {
namespace chatuvolchat {
    template<typename T>
    std::string to_string(T value)
    {
        std::stringstream ss;
        std::string result;

        ss << value;
        ss >> result;

        return result;
    }
} // chatuvolchat
} // uosipa
} // com

#endif // include guard
