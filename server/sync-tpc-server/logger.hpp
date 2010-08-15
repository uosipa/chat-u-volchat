#ifndef _CHAT_U_VOLCHAT__LOGGER_HPP_
#define _CHAT_U_VOLCHAT__LOGGER_HPP_

#include <string>

namespace com {
namespace uosipa {
namespace chatuvolchat {
    enum log_type
    {
        INF,
        WRN
    };

    class logger
    {
    public:
        logger(const std::string& id);

        void info(const std::string& message);
        void warn(const std::string& message);

    private:
        std::string id;
    };
} // chatuvolchat
} // uosipa
} // com

#endif // include guard
